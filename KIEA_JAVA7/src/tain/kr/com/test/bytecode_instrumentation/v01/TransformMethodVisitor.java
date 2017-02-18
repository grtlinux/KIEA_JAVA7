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

//import org.objectweb.asm.MethodVisitor;
//import org.objectweb.asm.Opcodes;
//
//import static org.objectweb.asm.Opcodes.ARETURN;
//import static org.objectweb.asm.Opcodes.ATHROW;
//import static org.objectweb.asm.Opcodes.DRETURN;
//import static org.objectweb.asm.Opcodes.FRETURN;
//import static org.objectweb.asm.Opcodes.IRETURN;
//import static org.objectweb.asm.Opcodes.LRETURN;
//import static org.objectweb.asm.Opcodes.RETURN;

public class TransformMethodVisitor { //extends MethodVisitor {
//    public TransformMethodVisitor(int i, MethodVisitor methodVisitor) {
//        super(i, methodVisitor);
//    }
//
//    @Override
//    public void visitInsn(int var1) {
//        switch (var1) {
//            case ARETURN:
//            case DRETURN:
//            case FRETURN:
//            case IRETURN:
//            case LRETURN:
//            case RETURN:
//            case ATHROW:
//                visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//                visitLdcInsn("Exception detected");
//                visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//            default:
//                break;
//        }
//        super.visitInsn(var1);
//    }
//
//    @Override
//    public void visitEnd() {
//        super.visitEnd();
//    }
}