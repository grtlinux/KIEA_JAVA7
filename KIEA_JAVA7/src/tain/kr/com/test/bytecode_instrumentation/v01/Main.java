/**
 * Copyright 2014, 2015, 2016, 2017 TAIN, Inc. all rights reserved.
 *
 * Licensed under the GNU GENERAL PUBLIC LICENSE, Version 3, 29 June 2007 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * -----------------------------------------------------------------
 * Copyright 2014, 2015, 2016, 2017 TAIN, Inc.
 *
 */
package tain.kr.com.test.bytecode_instrumentation.v01;

//import com.sun.tools.attach.VirtualMachine;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.lang.management.ManagementFactory;
//import java.util.jar.Attributes;
//import java.util.jar.JarEntry;
//import java.util.jar.JarOutputStream;
//import java.util.jar.Manifest;

/**
 * Created by Junhyeong Lim on 2017-02-02.
 */
public class Main {
    public static void main(String[] args) {
//        try {
//            String jvm = ManagementFactory.getRuntimeMXBean().getName();
//            String pid = jvm.substring(0, jvm.indexOf('@'));
//            VirtualMachine vm = VirtualMachine.attach(pid);
//            vm.loadAgent(generateJar(Agent.class, Utils.class, ClassTransformer.class, TransformClassVisitor.class, TransformMethodVisitor.class).getAbsolutePath());
//            throw new Exception();
//        } catch (Exception ex) {
//            // Ignore
//        }
    }

//    public static File generateJar(Class agent, Class... resources) throws IOException {
//        File jar = new File("agent.jar");
//        jar.deleteOnExit();
//
//        Manifest manifest = new Manifest();
//        Attributes attr = manifest.getMainAttributes();
//
//        attr.put(Attributes.Name.MANIFEST_VERSION, "1.0");
//        attr.put(new Attributes.Name("Agent-Class"), "kr.rvs.instrumentation.Agent");
//        attr.put(new Attributes.Name("Can-Retransform-Classes"), "true");
//        attr.put(new Attributes.Name("Can-Redefine-Classes"), "true");
//
//        JarOutputStream out = new JarOutputStream(new FileOutputStream(jar), manifest);
//        out.putNextEntry(new JarEntry(Utils.getClassName(Agent.class)));
//        out.write(Utils.getBytesAsClass(agent));
//        out.closeEntry();
//
//        for (Class cls : resources) {
//            String name = Utils.getClassName(cls);
//            out.putNextEntry(new JarEntry(name));
//            out.write(Utils.getBytesAsClass(cls));
//            out.closeEntry();
//        }
//
//        out.close();
//        return jar;
//    }
}