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
				<a class="navlink" id="nav_drivers" href="/ERS/listAllDrivers.action">Drivers</a>
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
	<s:if test="loggedIn == true">
		<div style="float: right; margin: 6px;">Hello <s:property value="currentUser" /> | <a href="logout.action">Logout</a></div>
	</s:if>
	<s:else>
		<div id="loginLinkDiv"><a id="loginLink" href="userLoginForm.action">Login</a></div>
	</s:else>
</div>
