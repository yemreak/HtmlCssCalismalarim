/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function openNavMenu(){
    var apple = document.getElementById("navMenu");
    if (apple.className === "navBar") {
        apple.className += " menu";
    } else {
        apple.className = "navBar";
    }
}
