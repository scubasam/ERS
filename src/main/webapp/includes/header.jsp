<%-- @authors Mitchell Nemitz, Kelly Smith --%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="debug">
	<s:property value="currentSession" />
</div>

<div id="heading">
	<h1>Enterprise Routing System</h1>
</div>

<div id="navbar">
	<div id="menu">
		<ul class="navbar">
			<li class="navitem">
				<a class="navlink" id="nav_home" href="/ERS/">Home</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_users" href="/ERS/userManagement.action">Users</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_contacts" href="/ERS/contactManagement.action">Contacts</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_contractors" href="/ERS/contractorManagement.action">Contractors</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_locations" href="/ERS/locationManagement.action">Locations</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_vehicles" href="/ERS/vehicleManagement.action">Vehicles</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_vehicletypes" href="/ERS/vehicleTypeManagement.action">Vehicle Types</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_drivers" href="/ERS/driverManagement.action">Drivers</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_technicians" href="/ERS/serviceTechnicianManagement.action">Technicians</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_maintenanceorders" href="/ERS/maintenanceOrderManagement.action">Maintenance Orders</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_shipments" href="/ERS/shipmentManagement.action">Shipments</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_routes" href="/ERS/routeManagement.action">Routes</a>
			</li>
		</ul>
	</div>
</div>

<div id="sub_heading">
	<div id="loginDiv">
		<s:if test="loggedIn == true">
			<a href="javascript:toggleColumnSelect();" class="ui-button" id="columnSelectButton">Select Columns</a>
			
			<div style="float: right;">
				Hello <s:property value="currentUser" /> 
				<a class="ui-button" href="logout.action" style="color: black !important;">Logout</a>
			</div>
		</s:if>
		<s:else>
			<div style="float: right;">
				<a id="loginLink" class="ui-button" href="userLoginForm.action">Login</a>
			</div>
		</s:else>
	</div>
</div>
