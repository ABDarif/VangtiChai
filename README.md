# VangtiChai

## *Abdullah Arif*

**VangtiChai** is an app that takes an amount of money as input & shows how many notes are needed to meet that specified amount.

Time spent: **10** hours

## Functionality

The following **required** functionality is completed:

* [x] Manual keypad is placed.
* [x] Real-time calculation of the number of notes.
* [x] Works in both portrait & landscape orientation with no data being lost.

## Video Walkthrough

Here's a walkthrough of implemented features:

<img src='https://s6.ezgif.com/tmp/ezgif-6-9da0df2ae0.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [ezgif](https://ezgif.com/maker).

## Notes

* [x] One of the most crucial challenges were to save all the data before screen rotation so that it keeps intact even after the rotation, Here came to play the "savedInstanceState" for retrieving all the data & "onSaveInstanceState" to restore all the data. One thing to note here, every time the screen gets rotated, "onCreate" method gets called from the very beginning each time
* [x] savedInstanceState & onSaveInstanceState: https://developer.android.com/guide/fragments/saving-state

## License

    Copyright [2024] [Abdullah Arif]
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.