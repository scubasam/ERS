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
				<a class="navlink" id="nav_users" href="/ERS/listAllUsers.action">Users</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_contacts" href="/ERS/listAllContacts.action">Contacts</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_contractors" href="/ERS/listAllContractors.action">Contractors</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_locations" href="/ERS/listAllLocations.action">Locations</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_vehicles" href="/ERS/listAllVehicles.action">Vehicles</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_vehicletypes" href="/ERS/listAllVehicleTypes.action">Vehicle Types</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_drivers" href="/ERS/listAllDrivers.action">Drivers</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_technicians" href="/ERS/listAllServiceTechnicians.action">Technicians</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_orders" href="/ERS/listAllMaintenanceOrders.action">Maintenance Orders</a>
			</li>
			<li class="navitem">
				<a class="navlink" id="nav_shipments" href="/ERS/listAllShipments.action">Shipments</a>
			</li>
		</ul>
	</div>
</div>

<div id="sub_heading">
	<s:if test="loggedIn == true">Hello <s:property value="currentUser" /> | <a href="logout.action">Logout</a></s:if>
	<s:else><a href="userLoginForm.action">Login</a></s:else>
</div>
