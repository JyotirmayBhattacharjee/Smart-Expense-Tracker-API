const API_URL = "/expenses";

const expenseForm = document.getElementById("expenseForm");
const expenseTable = document.getElementById("expenseTable");
const totalAmount = document.getElementById("totalAmount");
const filterCategory = document.getElementById("filterCategory");

window.onload = () => {
    loadExpenses();
};

expenseForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const expense = {
        title: document.getElementById("title").value,
        amount: Number(document.getElementById("amount").value),
        category: document.getElementById("category").value,
        date: document.getElementById("date").value
    };

    const response = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(expense)
    });

    if (response.ok) {
        expenseForm.reset();
        loadExpenses();
    } else {
        const error = await response.json();
        alert(JSON.stringify(error, null, 2));
    }
});

filterCategory.addEventListener("change", () => {

    if (filterCategory.value === "") {
        loadExpenses();
    } else {
        loadExpenses(filterCategory.value);
    }

});

async function loadExpenses(category = "") {

    let url = API_URL;

    if (category !== "") {
        url += "?category=" + category;
    }

    const response = await fetch(url);

    const expenses = await response.json();

    displayExpenses(expenses);

    updateTotal(category);
}

function displayExpenses(expenses) {

    expenseTable.innerHTML = "";

    expenses.forEach(expense => {

        expenseTable.innerHTML += `
            <tr>
                <td>${expense.id}</td>
                <td>${expense.title}</td>
                <td>₹${expense.amount}</td>
                <td>${expense.category}</td>
                <td>${expense.date}</td>
                <td>
                    <button
                        class="delete-btn"
                        onclick="deleteExpense(${expense.id})">
                        Delete
                    </button>
                </td>
            </tr>
        `;

    });

}

async function deleteExpense(id) {

    if (!confirm("Delete this expense?")) {
        return;
    }

    await fetch(API_URL + "/" + id, {
        method: "DELETE"
    });

    loadExpenses(filterCategory.value);

}

async function updateTotal(category = "") {

    let url = API_URL + "/total";

    if (category !== "") {
        url += "?category=" + category;
    }

    const response = await fetch(url);

    const data = await response.json();

    totalAmount.innerHTML = "₹" + data.total;

}
