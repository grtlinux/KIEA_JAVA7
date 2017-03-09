#
#
#

* Java���� Ŀ���� Ŭ�����ε带 �ۼ��ϴ� ��

Ŀ���� Ŭ�����δ��� �ۼ��ϴ� ����� �˾ƺ��� �ۼ��� Ŭ�����δ��� ����Ͽ� Ŭ������ �ε�Ǵ�
��Ȯ�� ������ Ȯ���� ������ �Ѵ�. ���⿡ ���õ� ������ Ŀ���� Ŭ�����δ��� ���� ���α׷��� �����ϴ�
Ŭ���� �߿��� Ư�� ��Ű���� ���Ե� Ŭ������ �ε��ϰ� ������ Ŭ������ �ý��� Ŭ�����δ��� ���� �ε�
�ǵ��� �� ���̴�.

�Ʒ��� ������ ������ ���� Ŀ�ǵ���� �ƱԸ�Ʈ�� ����Ͽ� JVM �ɼ��� �����Ͽ� JVM�� Ŭ������ �ε�
�� �� �ý��� Ŭ�����δ��� �ƴ� Ŀ���� Ŭ�����δ��� ����ϵ��� �����ϴ� ���̴�.

	java -Djava.system.class.loader=org.kdea.cloader.MyClassLoader Main

----------------------------------------------------------------------------------
package org.kdea.cloader;
 
import java.io.*;
  
// Ŭ������ �ε��� �� ���� Ŀ���� Ŭ���� �δ�
// �� Ŭ������ JVM �� ���ؼ� �ν��Ͻ��� �����ǰ� loadClass()�� ȣ��ǵ���
// �ۼ��Ǿ��� ������ ������ ���� Ŀ�ǵ���ο��� JVM���� ���޵Ǵ� �ɼ��� �����ؾ� �Ѵ�
// >java -Djava.system.class.loader=org.kdea.cloader.MyClassLoader [������ Ŭ����]
public class MyClassLoader extends ClassLoader
{
    // �ν��Ͻ��� ������ �� ���� Ŭ�����δ��� �θ� Ŭ�����δ��� ������ ��� �Ѵ�
    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }
 
    // Ŭ������ ���Ե� ��Ű���κ��� Ŭ������ �ε��Ͽ� Class �ν��Ͻ��� �����ϰ� �����Ѵ�
    private Class getClass(String name) throws ClassNotFoundException {
        String file = name.replace('.', File.separatorChar) + ".class";
        byte[] buf = null;
        try {
            // ���� �ý������κ��� .class ������ byte[]���� �ε��Ѵ�
            buf = loadBytes(file);
            // byte[]�� ������ �̸��� Ŭ������ �ش��ϴ� Class �ν��Ͻ��� ��ȯ�Ѵ�
            Class cls = defineClass(name, buf, 0, buf.length);
            resolveClass(cls); // ��ũ�Ѵ�. �̹� ��ũ�� ��쿡�� �ƹ� �͵� ���� �ʴ´�
            return cls;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
  
    // JVM�� Ŭ������ �ε��� �� �� �޼ҵ带 ȣ���Ͽ� Ŭ������ �ε��Ѵ�.
    // ���� ���α׷�(Ư�� ��Ű��)�� ���Ե� Ŭ������ Ŀ���� Ŭ�����δ��� �̿��Ͽ� �ε��ϰ�
    // �ý��� Ŭ������ �ý��� Ŭ�����δ��� �ε��ϵ��� �����Ѵ�(Delegation)
    @Override
    public Class loadClass(String name) throws ClassNotFoundException {
        System.out.println("�ε� ����("+name+")");
        if (name.startsWith("org.kdea.cloader")) {
            System.out.println("\t\t\t--> by MyClassLoader");
            return getClass(name);
        }
        return super.loadClass(name);
    }
  
    //���� �ý��ۿ��� .class ������ �о byte[] ������ �����Ѵ�
    private byte[] loadBytes(String name) throws IOException {
        InputStream stream =
                getClass().getClassLoader().getResourceAsStream(name);
        int size = stream.available();
        byte buff[] = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        return buff;
    }
}


��ó: http://micropilot.tistory.com/3026 []


----------------------------------------------------------------------------------
package org.kdea.cloader;
 
public class Main
{
    static{ System.out.println("* Main �ε�  �Ϸ� *"); }
     
    public static void main(String[] args)
    {
        ClassA a = new ClassA();
        a.createB();
         
        ClassA a2 = new ClassA();
        a2.createB();
    }
}


��ó: http://micropilot.tistory.com/3026 []
----------------------------------------------------------------------------------
package org.kdea.cloader;
 
public class ClassA
{
    static{ System.out.println("* ClassA �ε� �Ϸ� *"); }
     
    public ClassA(){
        System.out.println("ClassA �ν��Ͻ� ����");
    }
     
    public void createB()
    {
        System.out.println("ClassA.createB() �����");
        ClassB b = new ClassB();
    }
}


��ó: http://micropilot.tistory.com/3026 []
----------------------------------------------------------------------------------
package org.kdea.cloader;
 
public class ClassB
{
    static{ System.out.println("* ClassB �ε� �Ϸ� *"); }
     
    public ClassB()
    {
        System.out.println("ClassB �ν��Ͻ� ����");
    }
}


��ó: http://micropilot.tistory.com/3026 []
----------------------------------------------------------------------------------
----------------------------------------------------------------------------------
----------------------------------------------------------------------------------
----------------------------------------------------------------------------------

