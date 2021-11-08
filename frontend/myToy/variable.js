// JavaScript is very flexible
// flexible == dangerous
// added EcmaScript 5
'use strict';

console.log("Hello World!");
let a;
a = 5;

// 2. Variable
// let (added in ES6)
let globalName = 'global name';
{
    let name = 'ellie';
    console.log(name);
    name = 'hello';
    console.log(name);    
}
console.log(name);
console.log(globalName);

// var 
// var hoisting (어디에 선언했던 선언을 가장 위로 끌어 올려줌)
// var은 블럭 스코프가 없음. - 단점
console.log(age);
age = 4;
console.log(age);
var age;

// 3. Constants 상수 느낌
// favor immutable data type always for a few reasons;
// - security
// - thread safety
// - reduce human mistakes
const daysInWeek = 7;
const maxNumber = 5;

// symbol 같은 스트링 변수여도 서로 다르게 구분됨
const symbol1 = Symbol('id');
const symbol2 = Symbol('id');
console.log(symbol1 == symbol2); // false
const gSymbol1 = Symbol.for('id');
const gSymbol2 = Symbol.for('id');
console.log(gSymbol1 === gSymbol2); // true
console.log(`value: ${symbol1.description}, type: ${typeof symbol1}`);

// object, real-life object, data structure
const ellie = {name: 'ellie', age: 20};


// Dynamic typing: dynamiclly typed language
let text = 'hello';
console.log(text.charAt(0)); // h
console.log(`value: ${text}, type: ${typeof text}`); // string
text = 1;
console.log(`value: ${text}, type: ${typeof text}`); // number
text = '7' + 5;
console.log(`value: ${text}, type: ${typeof text}`); // string
text = '8' / '2';
console.log(`value: ${text}, type: ${typeof text}`); // number
console.log(text.charAt(0));