//========================================================================
//
//File:      $RCSfile: ConnectorMoveCommand.java,v $
//Version:   $Revision: 1.8.12.2 $
//Modified:  $Date: 2013/01/29 22:08:44 $
//
//
//========================================================================
// © 2013 Mentor Graphics Corporation
// Licensed under the Apache License, Version 2.0 (the "License"); you may not 
// use this file except in compliance with the License.  You may obtain a copy 
// of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
// WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   See the 
// License for the specific language governing permissions and limitations under
// the License.
//======================================================================== 
//
package com.mentor.nucleus.bp.ui.graphics.commands;

import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.commands.Command;

import com.mentor.nucleus.bp.ui.graphics.parts.ConnectorEditPart;
import com.mentor.nucleus.bp.ui.graphics.parts.DiagramEditPart;
import com.mentor.nucleus.bp.ui.graphics.utilities.GraphicsUtil;

public class ConnectorMoveCommand extends Command implements
		IValidateDeltaCommand {

	private ConnectorEditPart connector;

	public ConnectorMoveCommand(ConnectorEditPart connector) {
		this.connector = connector;
	}

	@Override
	public void execute() {
		connector.transferLocation();
		DiagramEditPart diagramPart = (DiagramEditPart) connector.getViewer()
				.getContents();
		diagramPart.resizeContainer();
	}

	@Override
	public boolean shouldExecute() {
		// if the connector move results in the same points
		// on the connector, then do not execute
		PointList modelPoints = GraphicsUtil
				.getPointsFromModelConnector(connector);
		if (GraphicsUtil.pointsAreEqual(connector.getConnectionFigure()
				.getPoints(), modelPoints)) {
			return false;
		}
		return true;
	}

}
