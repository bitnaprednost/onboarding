package hr.bitnaPrednost.noSpaceLeftOnDevice;

import hr.bitnaPrednost.noSpaceLeftOnDevice.file.FileImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileImplTest {
    private FileImpl file;
    @BeforeEach
    void setUp() {
        file = FileImpl.from("/", 0);
    }

    @Test
    public void canGetName(){
        assertEquals(file.getName(), "/");
    }

    @Test
    public void canGetType(){
        assertEquals(file.getType(), "file");
    }

    @Test
    public void canGetSize(){
        assertEquals(file.getSize(), 0L);
    }



}