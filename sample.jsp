<!DOCTYPE html>

<html lang="en" ng-app="myApp">
<head>


</head>
<body ng-controller="myCtrl">
<input type="text" ng-model="test" />

	<div class="container">
		<div class="starter-template">
			<form name="employeeform" method = "post"  enctype = "multipart/form-data"  ACTION="home" >
				<table>

					<tr>
						<td>Employee First Name :</td>
						<td><input type="text" id="fname" placeholder="First Name" />
						</td>
					</tr>



					<tr>
						<td>Employee Last Name :</td>
						<td><input type="text" path="lname" id="lname"
							placeholder="Last Name">
						</td>
					</tr>



					<tr>
						<td>Employee Department :</td>
						<td><select path="dept">
								<option value="1" label="IT"></option>
								<option value="2" label="Electronics"></option>
						</select></td>
					</tr>



					<tr>
						<td>Employee City :</td>
						<td><input type="text" path="city" id="city"
							placeholder="city"></input></td>
					</tr>


					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Save" ng-click="onSubmit()"></td>
							
						<!-- <input type = "file" name = "file" size = "50" />
         				<br />
						<input type="submit" value="Upload File" /> -->

						<td colspan="2" align="center"><input type="submit"
							value="Clear" OnClick="onClear()"></td>
							
						<td colspan="2" align="center"><input type="submit"
							value="Search" OnClick="onSearch()"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!-- /.container -->

	</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="/resources/scripts/employeeJs.js"></script>

</body>
</html>

