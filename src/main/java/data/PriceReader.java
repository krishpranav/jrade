package data;

import java.io.*;

public class PriceReader implements Closeable{
    private final DataInputStream stream;

    public PriceReader(String file) throws FileNotFoundException {
        this.stream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }
}