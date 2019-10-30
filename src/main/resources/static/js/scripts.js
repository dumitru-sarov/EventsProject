var closingID;

function makeTableBody (data) {

  for(var dataJson of data) {
    var title = document.getElementById('title');
    var description = document.getElementById('description');
    var location = document.getElementById('locationinfo');
    var date = document.getElementById('date');
    var userTable = document.getElementById('userTable');

    // data-toggle="modal" data-target="#myModal"

    var tr = document.createElement("tr");
    var tdTitle = document.createElement("td");
    var tdDescription = document.createElement("td");
    var tdLocation = document.createElement("td");
    var tdDate = document.createElement("td");
    var updateButton = document.createElement('button');
    var deleteButton = document.createElement('button');

    updateButton.innerHTML = "Update"
    $(updateButton).attr("class", "btn btn-default");
    $(updateButton).attr("id", dataJson.eventid);
    $(updateButton).attr("onclick", "getRowId(this.id)");
    $(updateButton).attr("data-toggle", "modal");
    $(updateButton).attr("data-target", "#myModal");
    deleteButton.innerHTML = "Delete";
    $(deleteButton).attr("class", "btn btn-default");
    $(deleteButton).attr("id", dataJson.eventid);
    // $(deleteButton).attr("onclick", "getRowId(this.id)");

    $(tr).attr("id", "row" + dataJson.eventid);

    tdTitle.innerHTML = dataJson.title;
    tdDescription.innerHTML = dataJson.description;
    tdLocation.innerHTML = dataJson.locationinfo;
    tdDate.innerHTML = dataJson.date;

    tr.appendChild(tdTitle);
    tr.appendChild(tdDescription);
    tr.appendChild(tdLocation);
    tr.appendChild(tdDate);
    tr.appendChild(updateButton);
    tr.appendChild(deleteButton);

    userTable.appendChild(tr);
  }
  // console.log("hello");
}

function showEvents() {
  axios.get('http://localhost:9090/allEvent').then(response => {
    makeTableBody(response.data);
    console.log(response.data);
  });
}

function postEvent() {
  let body = {};

  var title = document.getElementById('title');
  var description = document.getElementById('description');
  var location = document.getElementById('locationinfo');
  var date = document.getElementById('date');
  var eventAdd = document.getElementById('addEvent');

  body[date.name] = date.value;
  body[description.name] = description.value;
  body[locationinfo.name] = locationinfo.value;
  body[title.name] = title.value;

  console.log("hello");
  console.log(JSON.stringify(body));
  axios.post('http://localhost:9090/saveEvent', JSON.stringify(body), {
    headers: {
      'Content-Type' : 'application/json'
    }
  });

  // Jquery to add modal $(eventAdd).attr("data-dismiss","modal");

  return false;
  // data-dismiss="modal"
}

function getRowId(id) {
  console.log(id);

  var title = document.getElementById('title');
  var description = document.getElementById('description');
  var location = document.getElementById('locationinfo');
  var date = document.getElementById('date');
  var updateEvent = document.getElementById('updateEvent');

  updateEvent.removeAttribute("onsubmit");
  $(updateEvent).attr("onsubmit", "return updateFunction(this)");
  updateEvent.id = "event" + id;
  closingID = "event" + id;

  console.log(closingID);

  axios.get('http://localhost:9090/eventById/' + id).then(response => {
    console.log(response.data);

    var row = document.getElementById("row" + id);
    console.log(row.id);

    console.log(row.cells[0].innerHTML);

    title.value = row.cells[0].innerHTML;
    description.value = row.cells[1].innerHTML;
    location.value = row.cells[2].innerHTML;
    date.value = row.cells[3].innerHTML;
    });
  }

  function updateFunction(updateEvent) {
    let body = {};

    var eventNum = parseInt(updateEvent.id.replace(/[A-Za-z$-]/g, ""));
    console.log(eventNum);

    var title = document.getElementById('title');
    var description = document.getElementById('description');
    var location = document.getElementById('locationinfo');
    var date = document.getElementById('date');
    var eventAdd = document.getElementById('addEvent');

    // body[eventid] = id;
    body[date.name] = date.value;
    body[description.name] = description.value;
    body[locationinfo.name] = locationinfo.value;
    body[title.name] = title.value;

    console.log("hello");
    console.log(JSON.stringify(body));
    axios.put('http://localhost:9090/updateEvent/' + eventNum, JSON.stringify(body), {
      headers: {
        'Content-Type' : 'application/json'
      }
    });
    closing();
    return false;
  }

  function closing() {
    console.log(closingID);
    var updateEventId = document.getElementById(closingID);
    console.log("'" + closingID + "'");
    console.log(updateEventId);
    $(updateEventId).attr("id", "updateEvent")
    $(updateEventId).attr("onsubmit", "return postEvent(this)");
  }
  // var close1 = document.getElementById('close1');
  // var close2 = document.getElementById('close2');
  //
  // close1.addEventListener("click", closing());
  // close2.addEventListener("click", closing());
  showEvents();
