// scripts for account.html

// dynamically adding datasets to Datasets table
// id: DOM Element ID (must be unique)
// name: dataset name
// sharing: viewing permissions for company
function addDataSetEntry(id, name, sharing) {
  dom('#datasetstable>tbody').innerHTML += `
  <tr>
  <td>${name}</td>
  <td>
  <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="a${id}" data-bs-toggle="dropdown" aria-expanded="false">
  ${sharing}
  </button>
  <ul class="dropdown-menu" aria-labelledby="a${id}">
  <li><a class="dropdown-item" data-mutate="a${id}" href="#">Private</a></li>
  <li><a class="dropdown-item" data-mutate="a${id}" href="#">View Only</a></li>
  <li><a class="dropdown-item" data-mutate="a${id}" href="#">Edit</a></li>
  </ul>
  </div>
  </td>
  </tr>`
}

// dynamically adding user to Manageable Users table
// id: DOM Element ID (must be unique)
// name: username
// accountType: type of user account
function addManageableUserEntry(id, name, accountType) {
  dom('#manageableuserstable').innerHTML += `
  <tr id="a${id}">
  <td>${name}</td>
  <td id="b${id}" class="account-type">${accountType}</td>
  <td>
  <button type="button" data-mutate="b${id}" class="btn btn-secondary account-upgrade">Upgrade to Admin</button>
  <button type="button" data-mutate="a${id}" class="btn btn-secondary account-delete">Delete Account</button>
  </td>
  </tr>`
}

// TODO: replace with database data
addDataSetEntry(10, "Daves", "Private")
addManageableUserEntry(0, "Constantino", "Company User")


/* ------------------- Helpers ------------------- */

// retrieve the observer of this element
function getObserver(domElement) {
  return dom(`#${domElement.getAttribute('data-mutate')}`)
}


/* ------------------- Event Listeners ------------------- */

// change dropdown label on click
doms('.dropdown-item').forEach(e => e.addEventListener('click', function() {
  getObserver(this).innerText = this.innerText
}))

// delete account
doms('.account-delete').forEach(e => e.addEventListener('click', function() {
  let confirmed = window.confirm('Are you sure you want to delete your account? This action is permanent.')
  if (confirmed) getObserver(this).remove()
}))

// upgrade user to admin
doms('.account-upgrade').forEach(e => e.addEventListener('click', function() {
  this.classList.toggle('disabled')
  getObserver(this).innerText = "Admin"
}))
