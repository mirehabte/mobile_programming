val addButton = findViewById<Button>(R.id.addButton)
val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
val editTextVersion = findViewById<EditText>(R.id.editTextVersion)
val editTextCodeName = findViewById<EditText>(R.id.editTextCodeName)

addButton.setOnClickListener {
    val version = editTextVersion.text.toString()
    val codeName = editTextCodeName.text.toString()

    val tableRow = TableRow(this)

    val versionTextView = TextView(this)
    versionTextView.text = version

    val codeNameTextView = TextView(this)
    codeNameTextView.text = codeName

    tableRow.addView(versionTextView)
    tableRow.addView(codeNameTextView)

    tableLayout.addView(tableRow)
}
