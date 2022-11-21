 function check() {
     const price = document.getElementById("price");
     if (price < 0) {
         let textNode = document.createTextNode("Price must be positive value!");
         document.getElementById("errors").appendChild(textNode);
         return false;
     }
 }