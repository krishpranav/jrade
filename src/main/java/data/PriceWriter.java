package data;

import java.io.*;

public class PriceWriter implements Closeable {
    private final DataOutputStream stream;

    public PriceWriter(String file) throws FileNotFoundException {
        this.stream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }
}
