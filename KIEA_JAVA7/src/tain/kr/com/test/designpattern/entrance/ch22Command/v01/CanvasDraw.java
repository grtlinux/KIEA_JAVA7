/**
 * Copyright 2014, 2015, 2016 TAIN, Inc. all rights reserved.
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
 * Copyright 2014, 2015, 2016 TAIN, Inc.
 *
 */
package tain.kr.com.test.designpattern.entrance.ch22Command.v01;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : CanvasDraw.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch22Command.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class CanvasDraw extends Canvas implements DrawImpl {

	private static final long serialVersionUID = 1L;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Color color = Color.RED;
	
	private final int radius = 3;
	
	private final MacroCommand history;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public CanvasDraw(int width, int height, MacroCommand history) {
		setSize(width, height);
		setBackground(Color.WHITE);
		
		this.history = history;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void paint(Graphics g) {
		this.history.execute();
	}
	
	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(this.color);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
