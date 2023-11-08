val username = intent.getStringExtra("username")
welcomeTextView.text = "Welcome, $username!"

clothingImageView.setOnClickListener {
    Toast.makeText(this, "You have chosen the Clothing category of shopping.", Toast.LENGTH_SHORT).show()
}


