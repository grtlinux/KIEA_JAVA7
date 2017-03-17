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

//import org.objectweb.asm.ClassReader;
//import org.objectweb.asm.ClassVisitor;
//import org.objectweb.asm.ClassWriter;

import java.io.FileOutputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

//import static org.objectweb.asm.Opcodes.ASM5;

/**
 * Created by Junhyeong Lim on 2017-02-02.
 */
public class ClassTransformer implements ClassFileTransformer {
    @Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        byte[] ret = classfileBuffer;
        if (className.equals("java/lang/Exception")) {
            try {
//                ClassReader reader = new ClassReader("java.lang.Exception");
//                ClassWriter writer = new ClassWriter(0);
//                ClassVisitor visitor = new TransformClassVisitor(ASM5, writer);

//                reader.accept(visitor, 0);
//                ret = writer.toByteArray();

                FileOutputStream out = new FileOutputStream("Exception.class");
                out.write(ret);
                out.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return ret;
    }
}