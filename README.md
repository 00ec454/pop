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
Serously! Well not anymore. Look at the following code with fun way to write it with ~Pop.
```java
Pop.on(activity).with().title(R.string.title).body(R.string.body).show();
```
if you want to handle the button click, this is even more fun with naming and you can even have custom body of dialog.
```java
               Pop.on(this)
                    .with()
                    .title(R.string.title)
                    .layout(R.layout.custom_pop)
                    .when(new Pop.Yah() {
                        @Override
                        public void clicked(DialogInterface dialog, View view) {
                            Toast.makeText(getBaseContext(), "Yah button clicked", Toast.LENGTH_LONG).show();
                        }
                    })
                    .when(new Pop.Nah() {
                        @Override
                        public void clicked(DialogInterface dialog, View view) {
                            Toast.makeText(getBaseContext(), "Nah button clicked", Toast.LENGTH_LONG).show();
                        }
                    }).show();
```
##License

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
