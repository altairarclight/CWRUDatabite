// scripts for account.html

// check whether the password can be sent to the server
function passwordValidateSuccess() {
  let oldPass = dom('#oldPassword')
  let newPass = dom('#newPassword')
  let newPass2 = dom('#newPassword2')
  let errorPrompt = dom('#passwordError')
  if (newPass.value != newPass2.value) {
    errorPrompt.innerText = "Passwords do not match"
    return false
  }
  if (newPass.value.length < 8 || newPass2.value.length < 8) {
    errorPrompt.innerText = "New password must be at least 8 characters"
    return false
  }
  if (oldPass.value != "test") {
    errorPrompt.innerText = "Incorrect password"
    return false
  }
  return true
}

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
  <button class="btn btn-outline-primary dropdown-toggle" type="button" id="a${id}" data-bs-toggle="dropdown" aria-expanded="false">
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
  <td class="hidden">
  <button type="button" data-mutate="b${id}" class="btn btn-outline-primary account-upgrade">Upgrade to Admin</button>
  <button type="button" data-mutate="a${id}" data-bs-toggle="modal" data-bs-target="#deleteAccountModal" class="btn btn-danger account-delete">Delete Account</button>
  </td>
  </tr>`
}

// TODO: replace with database data
addDataSetEntry(10, "Daves", "Private")
addManageableUserEntry(0, "Constantino", "Company User")
addManageableUserEntry(1, "Constantino's", "Company User")
addManageableUserEntry(2, "Constantino'ss", "Company User")


/* ------------------- Helpers ------------------- */

// retrieve the observer of this element
function getObserver(domElement) {
  return dom(`#${domElement.getAttribute('data-mutate')}`)
}

// prompts a modal with custom text
// confirmFn is run when user confirms the prompt
function promptModal(modalDOM, titleHTML, bodyHTML, cancelText, confirmText, confirmFn) {
  dom(modalDOM, '.modal-header').innerHTML = titleHTML.outerHTML
  dom(modalDOM, '.modal-body').innerHTML = bodyHTML.outerHTML
  dom(modalDOM, '.modal-footer [data-my-btn-type="cancel"]').innerText = cancelText
  dom(modalDOM, '[data-my-btn-type="confirm"]').innerText = confirmText
  dom(modalDOM, '[data-my-btn-type="confirm"]').onclick = () => {
    confirmFn()
    bootstrap.Modal.getInstance(modalDOM).hide()
  }
}

/* ------------------- Event Listeners ------------------- */

// change dropdown label on click
doms('.dropdown-item').forEach(e => e.addEventListener('click', function() {
  getObserver(this).innerText = this.innerText
}))

// delete account
doms('.account-delete').forEach(e => e.addEventListener('click', function() {
  promptModal(dom('#deleteAccountModal'),
  makel('h5.modal-title', 'Are you sure you want to delete this account?'),
  makel('p', 'This action is permanent.'),
  'Cancel',
  'Yes, I want to delete this account',
  () => { this.closest('tr').remove() })
}))

// upgrade user to admin
doms('.account-upgrade').forEach(e => e.addEventListener('click', function() {
  this.classList.toggle('disabled')
  getObserver(this).innerText = "Admin"
}))

dom('#changePassword').addEventListener('click', function() {
  if (passwordValidateSuccess()) {} // send to server
})

dom('#editmanageableuserstable').addEventListener('click', function() {
  doms('#manageableuserstable .hidden').forEach(e => e.classList.remove('hidden'))
})
