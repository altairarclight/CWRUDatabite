// scripts for account.html

// dynamically adding datasets to Datasets table
function addDataSetEntry(id, name, sharing) {
  let entryHTML = `
  <tr>
  <td>${name}</td>
  <td>
  <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="datasetsdropdown${id}" data-bs-toggle="dropdown" aria-expanded="false">
  ${sharing}
  </button>
  <ul class="dropdown-menu" aria-labelledby="datasetsdropdown${id}">
  <li><a class="dropdown-item" href="#">Private</a></li>
  <li><a class="dropdown-item" href="#">View Only</a></li>
  <li><a class="dropdown-item" href="#">Edit</a></li>
  </ul>
  </div>
  </td>
  </tr>`
  dom('#datasetstable>tbody').innerHTML += entryHTML
}

// change dropdown label on click
doms('.dropdown-item').forEach(e => e.addEventListener('click', function() {
  dom(`#${this.parentNode.parentNode.getAttribute("aria-labelledby")}`).innerText = this.innerText
}))
