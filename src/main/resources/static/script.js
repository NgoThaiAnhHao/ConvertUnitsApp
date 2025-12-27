const units = {
  length: [
    "millimeter",
    "centimeter",
    "meter",
    "kilometer",
    "inch",
    "foot",
    "yard",
    "mile",
  ],
  weight: ["milligram", "gram", "kilogram", "ounce", "pound"],
  temperature: ["celsius", "fahrenheit", "kelvin"],
};

const tabs = document.querySelectorAll(".unit-option");
const unitFromSelect = document.querySelector(".unit-convert-from");
const unitToSelect = document.querySelector(".unit-convert-to");
const typeInput = document.getElementById("typeInput");
const sectionInput = document.querySelector(".input-value");
const sectionResult = document.querySelector(".result-value");
const resetBtn = document.querySelector(".reset-btn");
const convertBtn = document.querySelector(".convert-btn");

// For active tab
tabs.forEach((tab) => {
  tab.addEventListener("click", () => {
    // Delete old active
    tabs.forEach((t) => t.classList.remove("active"));

    // Set new active
    tab.classList.add("active");

    // Log current type
    const currentType = tab.dataset.type;
    console.log("Current type: " + currentType);

    typeInput.value = currentType;

    renderUnits(currentType);
  });
});

// Info of type tab such as Length, Weight, Temp,....
function renderUnits(type) {
  unitFromSelect.innerHTML = "";
  unitToSelect.innerHTML = "";

  units[type].forEach((unit) => {
    const optionFrom = document.createElement("option");
    optionFrom.value = unit;
    optionFrom.textContent = unit;

    const optionTo = document.createElement("option");
    optionTo.value = unit;
    optionTo.textContent = unit;

    unitFromSelect.appendChild(optionFrom);
    unitToSelect.appendChild(optionTo);
  });
}

// resetBtn.addEventListener("click", () => {
//   sectionInput.classList.remove("hidden");
//   sectionResult.classList.add("hidden");
//   typeInput.value = "length";
// });
//
// convertBtn.addEventListener("click", () => {
//   sectionResult.classList.remove("hidden");
//   sectionInput.classList.add("hidden");
// });
