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

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;

/**
 * Created by Junhyeong Lim on 2017-02-02.
 */
public class Agent {
    public static void agentmain(String agentArg, Instrumentation inst) throws Exception {
        inst.addTransformer(new ClassTransformer());

        InputStream inStream = ClassLoader.getSystemResourceAsStream("java/lang/Exception.class");
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        int read;
        byte[] data = new byte[65536];
        while ((read = inStream.read(data, 0, data.length)) != -1) {
            outStream.write(data, 0, read);
        }

        inst.redefineClasses(new ClassDefinition(Exception.class, outStream.toByteArray()));
    }
}