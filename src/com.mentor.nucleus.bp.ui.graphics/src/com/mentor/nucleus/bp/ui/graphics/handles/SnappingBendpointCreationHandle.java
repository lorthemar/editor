//========================================================================
//
//File:      $RCSfile: SnappingBendpointCreationHandle.java,v $
//Version:   $Revision: 1.6.12.2 $
//Modified:  $Date: 2013/01/29 22:09:55 $
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
package com.mentor.nucleus.bp.ui.graphics.handles;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.handles.BendpointCreationHandle;

import com.mentor.nucleus.bp.ui.graphics.trackers.SnappingBendpointTracker;

public class SnappingBendpointCreationHandle extends BendpointCreationHandle {

	public SnappingBendpointCreationHandle(ConnectionEditPart owner, int index,
			int locatorIndex) {
		super(owner, index, locatorIndex);
	}

	@Override
	public DragTracker getDragTracker() {
		SnappingBendpointTracker tracker = new SnappingBendpointTracker(
				(ConnectionEditPart) getOwner(), getIndex());
		tracker.setType(RequestConstants.REQ_CREATE_BENDPOINT);
		tracker.setDefaultCursor(getCursor());
		return tracker;
	}
	
}
