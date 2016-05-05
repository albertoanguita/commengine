package jacz.commengine.channel.tests.test1;

/**
 * Class description
 * <p/>
 * User: Alberto<br>
 * Date: 16-dic-2008<br>
 * Last Modified: 16-dic-2008
 */
public class PT2 implements Runnable {

    private int port;

    public PT2(int port) {
        this.port = port;
    }

    public void run() {
        Test1 t2 = new Test1("t2");

        t2.connect(port);
        t2.write((byte) 1, "hola t1");
    }
}
