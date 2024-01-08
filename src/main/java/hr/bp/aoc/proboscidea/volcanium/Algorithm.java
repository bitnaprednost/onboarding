package hr.bp.aoc.proboscidea.volcanium;

import hr.bp.aoc.proboscidea.volcanium.command.Command;
import hr.bp.aoc.proboscidea.volcanium.command.Move;
import hr.bp.aoc.proboscidea.volcanium.command.Open;
import hr.bp.aoc.proboscidea.volcanium.util.tree.TreeNode;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * <p>Algorithm class.</p>
 *
 * @author Marko Krišković
 */
public class Algorithm {
    private static final Logger logger = LoggerFactory.getLogger(Algorithm.class);
    private VulcanoManager manager;

    public Algorithm(VulcanoManager manager) {
        this.manager = manager;
    }

    private void addOpenCommandToTree(TreeNode<Command> current, int depth, Graph graphCopy, Valve currentValve) {
        Optional<Valve> optionalValve = graphCopy.findValve(currentValve.getName());

        if(optionalValve.isPresent() && !optionalValve.get().isOpen()){
            Command command = new Open(currentValve, manager);
            graphCopy.setToZero(currentValve);

            TreeNode<Command> child = current.addChild(command);
            createDecisionTree(child, depth -1, graphCopy.copy());
        }
    }

    private void addNeighborToTree(TreeNode<Command> node, int depth, Optional<Valve> neighbor, Graph graphCopy) {
        if(neighbor.isPresent()){
            Command command = new Move(neighbor.get(), manager);
            TreeNode<Command> child = node.addChild(command);
            createDecisionTree(child, depth -1, graphCopy.copy());
        }
    }

    private void createDecisionTree(TreeNode<Command> current, int depth, Graph graphCopy) {
        if(depth>0) {
            Valve currentValve = current.data.getValve();

            addOpenCommandToTree(current, depth, graphCopy, currentValve);

            for (String neighStr : currentValve.getNeighbors()) {
                Optional<Valve> neighbor = manager.getGraph().findValve(neighStr);
                addNeighborToTree(current, depth, neighbor, graphCopy);
            }
        }
    }

    private TreeNode<Command> createDecisionTree(int depth) {
        Command starting = new Move(manager.getCurrent(), manager);
        TreeNode<Command> root = new TreeNode<>(starting);

        createDecisionTree(root, depth, manager.getGraph().copy());

        return root;
    }

    private int getMaxPressure(TreeNode<Command> currentNode, int pressure) {
        if(currentNode.data instanceof Open) pressure += currentNode.data.getValve().getRate();
        if(currentNode.isLeaf()) return pressure;

        int max = 0;
        for (TreeNode<Command> child : currentNode.children) {
            int maxPressure = getMaxPressure(child, pressure);

            if(maxPressure > max) max = maxPressure;
        }
        return pressure + max;
    }

    private Command chooseBestCommand(TreeNode<Command> decisionTree) {
        Command command = decisionTree.children.get(0).data;
        int max = 0;
        for (TreeNode<Command> child : decisionTree.children) {
            int maxPressure = getMaxPressure(child, 0);
            if(maxPressure > max){
                max = maxPressure;
                command = child.data;
            }
        }

        return command;
    }

    public Command findBestStep(int depth) {
        Validate.isTrue(depth>0, "Depth must be a positive integer.");

        TreeNode<Command> decisionTree = createDecisionTree(depth);
        Command command = chooseBestCommand(decisionTree);

        return command;
    }

    public void nextStep(int depth) {
        Command command = findBestStep(depth);
        manager.releasePreassure();
        command.execute();

        logger.info(command.toString());
        logger.info("");
    }

    public void nextSteps(int times, int depth) {
        Validate.isTrue(times>0, "Number of iterations must be a positive integer.");

        for(int i=0;i<times;i++){
            logger.info("== Minute " + (i+1) + " ==");
            logger.info("released "+ manager.getPressure() + " pressure");

            nextStep(depth);
        }
    }
}
