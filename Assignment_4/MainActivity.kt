val users = ArrayList<User>()

// Add users to the list
users.add(User("John", "Doe", "john@example.com", "pas1"))
users.add(User("Mire", "Hab", "mire@example.com", "pas2"))

signInButton.setOnClickListener {
    val enteredUsername = usernameEditText.text.toString()
    val enteredPassword = passwordEditText.text.toString()

    val user = users.find { it.username == enteredUsername && it.password == enteredPassword }

    if (user != null) {
        // Match found, open ShoppingCategory activity
        val intent = Intent(this, ShoppingCategoryActivity::class.java)
        intent.putExtra("username", user.firstname)
        startActivity(intent)
    } else {
        Toast.makeText(this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show()
    }
}
