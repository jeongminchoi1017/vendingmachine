// i am

function VendingMachine(keyString = "qwer") {
    this.keyString = keyString;
    this.insertedMoney = 0;
    this.drinksArr = [{ name: "솔의눈", amount: 10, price: 700 }];
    
    // 동전 넣기
    this.insertCoin = function (coin = 0) {
      // coin number?
  
      // coin minus??
  
      this.insertedMoney += coin;
      console.log("현재 잔액 : ", this.insertedMoney);
    };
  
    // 거슬러주기
    this.returnCoin = function () {
      console.log("동전을 돌려드립니다 : ", this.insertedMoney);
      this.insertedMoney = 0;
    };
  
    // 물품 선택 (랜덤도?)
    this.selectProduct = function (productName = "솔의눈") {
      // 해당 물품이 있는가?
      const theProduct = this.drinksArr.find((drinkObject) => {
        // name / amount / price
        return drinkObject.name == productName;
      });
  
      if (!theProduct) {
        console.log("물품이 없습니다. 다시 선택해주세요");
        return;
      }
  
      // 수량이 충분한지?
      if (theProduct.amount < 1) {
        console.log("해당 물품은 다 떨어졌습니다. 다른 물품을 선택해주세요.");
        return;
      }
  
      // 돈이 충분한지?
      if (this.insertedMoney < theProduct.price) {
        console.log("돈이 부족합니다. 동전을 더 넣어주세요");
        return;
      }
  
      // 물품 반환
      console.log("맛있게 드세요! : ", theProduct.name);
      this.insertedMoney -= 700;
      theProduct.amount -= 1;
    };
    // 새 음료 넣기
    this.insertDrink = function(product = {name: "콜라", amount : 10, price : 900}){
        this.drinksArr.push(product);
        console.log("새로운 음료 추가 : ", product);
    }
    // 기존 음료수 10으로 만들기
    this.changeAmount = function(){
        // drinkArr의 물품 전부 amount값을 10으로 변경
        this.drinksArr.forEach((drinkObject)=>{drinkObject.amount = 10});
    }

  }
  
  const myVendingMachine = new VendingMachine("");
  
  myVendingMachine.insertCoin(600);
  myVendingMachine.insertCoin(600);
  myVendingMachine.insertCoin(600);
  myVendingMachine.insertCoin(600);
  
  myVendingMachine.selectProduct("솔의눈");
  myVendingMachine.selectProduct("솔의눈");
  myVendingMachine.selectProduct("솔의눈");

  console.log(myVendingMachine.drinksArr);
  
  myVendingMachine.returnCoin();
  myVendingMachine.insertDrink({name: "콜라", amount : 10, price : 900});
  myVendingMachine.changeAmount();
  console.log(myVendingMachine.drinksArr);