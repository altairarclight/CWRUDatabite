function generateCompanyID() {
  // Disable the button
  document.getElementById("reg_CompanyID").disabled = true;

  var down = document.getElementById('code');
  
down.innerHTML = ("" + Math.random()).substring(2, 8);

}