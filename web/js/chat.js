const suggestions = [
  "HTML",
  "CSS",
  "JavaScript",
  "React",
  "Node.js",
  "Python",
  "PHP",
  "Vue.js",
];
const input = document.getElementById("searchInput");
const autocompleteBox = document.getElementById("autocomplete");
const clear = document.querySelector(".clear");

function showSuggestions() {
  const value = input.value.toLowerCase();
  autocompleteBox.innerHTML = "";
  clear.style.display = value ? "block" : "none";

  if (value) {
    const filtered = suggestions.filter((item) =>
      item.toLowerCase().includes(value)
    );
    filtered.forEach((item) => {
      const div = document.createElement("div");
      div.textContent = item;
      div.onclick = () => {
        input.value = item;
        autocompleteBox.innerHTML = "";
      };
      autocompleteBox.appendChild(div);
    });
  }
}

function search() {
  const value = input.value.trim();
  if (value) {
    alert("Đang tìm kiếm: " + value);
    autocompleteBox.innerHTML = "";
  }
}

function clearInput() {
  input.value = "";
  autocompleteBox.innerHTML = "";
  clear.style.display = "none";
  input.focus();
}

function checkEnter(e) {
  if (e.key === "Enter") {
    search();
  }
}
