# pop - A quick android dialog building lib
[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Pop-green.svg?style=true)](https://android-arsenal.com/details/1/3400)

![demo](https://github.com/00ec454/pop/blob/master/assets/pop.gif)

## Oneline of code and you have it.

```java
Pop.on(activity).with().title(R.string.title).body(R.string.body).show();
```

## How to include it in your project:

Add `compile 'com.vistrav:pop:2.3'` in your app's gradle.build file in `dependencies` section and that is it! Just like this.

```groovy
dependencies {
	compile 'com.vistrav:pop:2.3'
}
``` 

## Adding buttons and custom body
if you want to handle the button click, this is even more fun with naming and you can even have custom body of dialog.
```java
               Pop.on(this)
                    .with()
                    .title(R.string.title)
                    .icon(R.drawable.icon)
                    .cancelable(false)
                    .layout(R.layout.custom_pop)
                    .when(new Pop.Yah() {
                        @Override
                        public void clicked(DialogInterface dialog, View view) {
                            Toast.makeText(getBaseContext(), "Yah button clicked", Toast.LENGTH_LONG).show();
                        }
                    })
                    .when(new Pop.Nah() { // ignore if dont need negative button
                        @Override
                        public void clicked(DialogInterface dialog, View view) {
                            Toast.makeText(getBaseContext(), "Nah button clicked", Toast.LENGTH_LONG).show();
                        }
                    })
                    .show(new Pop.View() { // assign value to view element
                          @Override
                          public void prepare(View view) {
                            EditText etName = (EditText) view.findViewById(R.id.et_name);
                            Log.i(TAG, "etName :: " + etName.getText());
                            etName.setText("Test Name 123");
                          }
                     });
```

## You can contribute!
In case you think you have some improvement, please feel free do pull request your feature and I would be happy to include it. Let's make this Pop very easy to use and rich with features.

## Other Userful Libraries
#### Ask - Android runtime permissions make easy
[![Github](https://img.shields.io/badge/github-Ask-orange.svg)](https://github.com/00ec454/Ask) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Ask-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3465)

## License

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/00ec454/pop/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

