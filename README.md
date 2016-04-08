# pop - a quick android dialog building lib
[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

Buiding a dialog in android is why so much pain! Look at the following code you need to build a simple Dialog.
```java
AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
builder.setTitle(R.string.pick_toppings);
builder.setBody(R.string.body)

// Add the buttons
builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
               // User clicked OK button
           }
       });
builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
               // User cancelled the dialog
           }
       });
// Set other dialog properties
...

// Create the AlertDialog
AlertDialog dialog = builder.create();
```
Serously! Well not anymore. Look at the following code with fun way to write it.
```java
Pop.on(this).with().title(R.string.title).body(R.string.body).show();
```
