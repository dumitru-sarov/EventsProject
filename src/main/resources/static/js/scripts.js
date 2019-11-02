var closingID;
var host = location.hostname;

var closingID;
var eventAdd = document.getElementById('addEvent');

function makeTableBody (data) {
  console.log(data);

  var userTable = document.getElementById('userTable');
  var counter = 0;

  for(var dataJson of data) {

    var type = document.getElementById('eventType');
    var title = document.getElementById('title');
    var description = document.getElementById('description');
    var location = document.getElementById('locationinfo');
    var date = document.getElementById('date');


    var tr = document.createElement("tr");
    var tdType = document.createElement("td");
    var tdTitle = document.createElement("td");
    var tdDescription = document.createElement("td");
    var tdLocation = document.createElement("td");
    var tdDate = document.createElement("td");
    var updateButton = document.createElement('button');
    var deleteButton = document.createElement('button');

    updateButton.innerHTML = "Update"
    $(updateButton).attr("class", "btn btn-default updateButton");
    $(updateButton).attr("id", dataJson.eventid);
    $(updateButton).attr("onclick", "getRowId(this.id)");
    $(updateButton).attr("data-toggle", "modal");
    $(updateButton).attr("data-target", "#myModal");
    deleteButton.innerHTML = "Delete";
    $(deleteButton).attr("class", "btn btn-default deleteButton");
    $(deleteButton).attr("id", dataJson.eventid);
    $(deleteButton).attr("onclick", "deleteRecord(this.id)");

    $(tr).attr("id", "row" + dataJson.eventid);

    tdTitle.innerHTML = dataJson.title;
    tdDescription.innerHTML = dataJson.description;
    tdLocation.innerHTML = dataJson.locationinfo;
    tdDate.innerHTML = dataJson.date;
    tdType.innerHTML = dataJson.eventtype;

    tr.appendChild(tdTitle);
    tr.appendChild(tdDescription);
    tr.appendChild(tdLocation);
    tr.appendChild(tdDate);
    tr.appendChild(tdType);
    tr.appendChild(updateButton);
    tr.appendChild(deleteButton);

    userTable.appendChild(tr);
  }

  populateGrid(userTable);
}

  function populateGrid(allEvents) {
    var iterations = 0;
    if (allEvents.rows.length >= 7) {
      console.log("hello");
      iterations = 7;
    }
    else {
      console.log("hello too");
      iterations = allEvents.rows.length;
    }

    for (var i = 0; i < iterations; i++) {
      var grid = document.getElementById('grid' + i);
      var img = document.getElementById('img' + i)
      console.log(allEvents.rows[i].cells);
      var row = allEvents.rows[i].cells;

      grid.innerHTML = row[0].innerHTML + "<br>" + row[2].innerHTML + "<br>" + row[3].innerHTML;

      var activityType = row[4].innerHTML;

      console.log(activityType);

      if (activityType == "Sport Activity") {
        img.src = "imgs/football.jpg";
        img.alt = "Sport Activity";
      }
      else if (activityType == "Social"){
        img.src = "imgs/social.jpg";
        img.alt = "Social";
      }
      else if (activityType == "Birthday"){
        img.src = "imgs/birthday.jpg";
        img.alt = "Birthday";
      }
      else if (activityType == "Wedding"){
        img.src = "imgs/wedding.jpg";
        img.alt = "Wedding";
      }
      else if (activityType == "Anniversary"){
        img.src = "imgs/anniversary.jpg";
        img.alt = "Anniversary";
      }
      else if (activityType == "Meeting"){
        img.src = "imgs/meeting.jpg";
        img.alt = "Meeting";
      }
      else if (activityType == "Concert"){
        img.src = "imgs/concert.jpg";
        img.alt = "Concert";
      }
      else {
        img.src = "imgs/other.jpg";
        img.alt = "Other";
      }
    }
  }

function showEvents() {
  axios.get('http://'+host+':9090/allEvent').then(response => {
    document.getElementById('userTable').innerHTML = "";
    makeTableBody(response.data);
  });
}

function postEvent() {
  showEvents();
  let body = {};

  var type = document.getElementById('eventType');
  var title = document.getElementById('title');
  var description = document.getElementById('description');
  var location = document.getElementById('locationinfo');
  var date = document.getElementById('date');

  body[type.name] = type.options[type.selectedIndex].innerHTML;
  body[date.name] = date.value;
  body[description.name] = description.value;
  body[locationinfo.name] = locationinfo.value;
  body[title.name] = title.value;

  axios.post('http://'+host+':9090/saveEvent', JSON.stringify(body), {
    headers: {
      'Content-Type' : 'application/json'
    }
  });

  console.log("hello");
  showEvents();

  // return false;
}

function getRowId(id) {
  console.log(id);

  var title = document.getElementById('title');
  var description = document.getElementById('description');
  var location = document.getElementById('locationinfo');
  var date = document.getElementById('date');
  var type = document.getElementById('eventType');
  var updateEvent = document.getElementById('updateEvent');

  updateEvent.removeAttribute("onsubmit");
  $(updateEvent).attr("onsubmit", "return updateFunction(this)");
  updateEvent.id = "event" + id;
  closingID = "event" + id;

  console.log(closingID);

  axios.get('http://'+host+':9090/eventById/' + id).then(response => {
    console.log(response.data);

    var row = document.getElementById("row" + id);
    console.log(row.id);

    title.value = row.cells[0].innerHTML;
    description.value = row.cells[1].innerHTML;
    location.value = row.cells[2].innerHTML;
    date.value = row.cells[3].innerHTML;
    type.value = row.cells[4].innerHTML;

    });
  }

  function updateFunction(updateEvent) {
    showEvents();
    let body = {};

    var eventNum = parseInt(updateEvent.id.replace(/[A-Za-z$-]/g, ""));
    console.log(eventNum);

    var title = document.getElementById('title');
    var description = document.getElementById('description');
    var location = document.getElementById('locationinfo');
    var date = document.getElementById('date');
    var type = document.getElementById('eventType');
    var eventAdd = document.getElementById('addEvent');

    body[date.name] = date.value;
    body[description.name] = description.value;
    body[locationinfo.name] = locationinfo.value;
    body[title.name] = title.value;
    body[type.name] = type.options[type.selectedIndex].value;

    console.log("hello");
    console.log(JSON.stringify(body));
    axios.put('http://'+host+':9090/updateEvent/' + eventNum, JSON.stringify(body), {
      headers: {
        'Content-Type' : 'application/json'
      }
    });
    closing();
    showEvents();
  }

  function deleteRecord(id) {
    var deleteRow = document.getElementById('row' + id);
    console.log(deleteRow);

    axios.delete('http://'+host+':9090/deleteEvent/' + id, {
      headers: {
        'Content-Type' : 'application/json'
      }
    });

    deleteRow.remove();

    console.log(id);
  }

  function closing() {
    console.log(closingID);
    var updateEventId = document.getElementById(closingID);
    $(updateEventId).attr("id", "updateEvent")
    $(updateEventId).attr("onsubmit", "return postEvent(this)");
  }

  function triggerModal() {
    document.getElementById('popModal').click();
  }

  showEvents();
