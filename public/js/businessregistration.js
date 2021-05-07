function generateCompanyID() {
  // Disable the button
  document.getElementById("reg_CompanyID").disabled = true;

  var down = document.getElementById('code');
  
down.innerHTML = ("" + Math.random()).substring(2, 8);

}

function rand(){
  return Math.floor(Math.floor(100000 + Math.random() * 900000));
}

function setRand(){
  document.getElementById('rand').value = rand();
}