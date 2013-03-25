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
				<a class="navlink<s:if test='currentPage == home'> currentpage</s:if>" href="/ERS/">Home</a>
			</li>
			<li class="navitem">
				<a class="navlink" href="/ERS/listAllUsers.action">Users</a>
			</li>
			<li class="navitem">
				<a class="navlink" href="/ERS/listAllContacts.action">Contacts</a>
			</li>
			<li class="navitem">
				<a class="navlink" href="/ERS/listAllContractors.action">Contractors</a>
			</li>
			<li class="navitem">
				<a class="navlink" href="/ERS/listAllLocations.action">Locations</a>
			</li>
			<li class="navitem">
				<a class="navlink" href="/ERS/listAllVehicles.action">Vehicles</a>
			</li>
			<li class="navitem">
				<a class="navlink" href="/ERS/listAllVehicleTypes.action">Vehicle Types</a>
			</li>
			<li class="navitem">
				<a class="navlink" href="/ERS/listAllDrivers.action">Drivers</a>
			</li>
			<li class="navitem">
				<a class="navlink" href="/ERS/listAllServiceTechnicians.action">Technicians</a>
			</li>
			<li class="navitem">
				<a class="navlink" href="/ERS/listAllMaintenanceOrders.action">Maintenance Orders</a>
			</li>
			<li class="navitem">
				<a class="navlink" href="/ERS/listAllShipments.action">Shipments</a>
			</li>
		</ul>
	</div>
</div>

<div id="sub_heading">
	<s:if test="loggedIn == true">
		Hello <s:property value="currentUser" /> | <a href="logout.action">Logout</a>
	</s:if>
	<s:else>
		<a href="userLoginForm.action">Login</a>
	</s:else>
</div>
