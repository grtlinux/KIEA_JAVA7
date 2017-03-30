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
package tain.kr.com.test.mon.v01;

import org.apache.log4j.Logger;
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTest.java
 *   -. Package    : tain.kr.com.test.mon.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 30. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MainTest {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTest.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainTest() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new MainTest();

		if (!flag) {
			/*
			 * Cpu
			 */
			Sigar sigar;
			Cpu cpu = new Cpu();
			//Cpu[] arrCpu = sigar.getCpuList();
			//CpuInfo[] arrCpuInfo = sigar.getCpuInfoList();
			//CpuPerc cpuPerc = sigar.getCpuPerc();
			//CpuPerc[] arrCpuPerc = sigar.getCpuPercList();
			
			for (int i=0; i < 1000; i++) {
				sigar = new Sigar();
				cpu.gather(sigar);
				
				System.out.printf("%d %d %d %d %d\n"
						, cpu.getIdle()
						, cpu.getSys()
						, cpu.getUser()
						, cpu.getWait()
						, cpu.getTotal()
						);
				
				try { Thread.sleep(1000); } catch (InterruptedException e) {}
			}
		}
		
		if (!flag) {
			/*
			 * Cpu[]
			 */
			Sigar sigar;
			Cpu[] arrCpu;
			
			for (int i=0; i < 1000; i++) {
				sigar = new Sigar();
				arrCpu = sigar.getCpuList();
				
				System.out.printf("arrCpu.length = %d\n", arrCpu.length);
				for (int idx=0; idx < arrCpu.length; idx++) {
					System.out.printf("\t[%d] %d %d %d %d %d\n"
							, idx
							, arrCpu[idx].getIdle()
							, arrCpu[idx].getSys()
							, arrCpu[idx].getUser()
							, arrCpu[idx].getWait()
							, arrCpu[idx].getTotal()
							);
				}
				
				try { Thread.sleep(1000); } catch (InterruptedException e) {}
			}
		}
		
		if (!flag) {
			/*
			 * CpuInfo[]
			 */
			Sigar sigar;
			CpuInfo[] arrCpuInfo;
			
			for (int i=0; i < 1000; i++) {
				sigar = new Sigar();
				arrCpuInfo = sigar.getCpuInfoList();
				
				System.out.printf("arrCpuInfo.length = %d\n", arrCpuInfo.length);  // -> 0
				for (int idx=0; idx < arrCpuInfo.length; idx++) {
					System.out.printf("\t[%d] %d %d %d %s %d %d %s\n"
							, idx
							, arrCpuInfo[idx].getCacheSize()
							, arrCpuInfo[idx].getCoresPerSocket()
							, arrCpuInfo[idx].getMhz()
							, arrCpuInfo[idx].getModel()
							, arrCpuInfo[idx].getTotalCores()
							, arrCpuInfo[idx].getTotalSockets()
							, arrCpuInfo[idx].getVendor()
							);
				}
				
				try { Thread.sleep(10000); } catch (InterruptedException e) {}
			}
		}
		
		if (!flag) {
			/*
			 * CpuPerc[]
			 */
			Sigar sigar;
			CpuPerc[] arrCpuPerc;
			
			for (int i=0; i < 1000; i++) {
				sigar = new Sigar();
				arrCpuPerc = sigar.getCpuPercList();
				
				System.out.printf("arrCpuPerc.length = %d\n", arrCpuPerc.length);
				for (int idx=0; idx < arrCpuPerc.length; idx++) {
					System.out.printf("\t[%d] %f %f %f %f %f %f %f %f %f\n"
							, idx
							, arrCpuPerc[idx].getCombined()
							, arrCpuPerc[idx].getIdle()
							, arrCpuPerc[idx].getIrq()
							, arrCpuPerc[idx].getNice()
							, arrCpuPerc[idx].getSoftIrq()
							, arrCpuPerc[idx].getStolen()
							, arrCpuPerc[idx].getSys()
							, arrCpuPerc[idx].getUser()
							, arrCpuPerc[idx].getWait()
							);
				}
				
				try { Thread.sleep(10000); } catch (InterruptedException e) {}
			}
		}
		
		if (flag) {
			/*
			 * CpuPerc
			 */
			Sigar sigar;
			CpuPerc cpuPerc;
			
			for (int i=0; i < 1000; i++) {
				sigar = new Sigar();
				cpuPerc = sigar.getCpuPerc();
				
				System.out.printf("\t%f %f %f %f %f %f %f %f %f\n"
						, cpuPerc.getCombined()
						, cpuPerc.getIdle()
						, cpuPerc.getIrq()
						, cpuPerc.getNice()
						, cpuPerc.getSoftIrq()
						, cpuPerc.getStolen()
						, cpuPerc.getSys()
						, cpuPerc.getUser()
						, cpuPerc.getWait()
						);
				
				try { Thread.sleep(2000); } catch (InterruptedException e) {}
			}
		}
	}

	/*
	 * main method
	 */
	public static void main(String[] args) throws Exception {

		if (flag)
			log.debug(">>>>> " + new Object() {
			}.getClass().getEnclosingClass().getName());

		if (flag) test01(args);  // cpu information
		
		// disk information
		
		// network information
		
		// user information
		
		// processes information
		
		
		
	}
}
