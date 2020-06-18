/* globals Chart:false, feather:false */

(function () {
    'use strict'

    feather.replace()

    // Graphs
    var ctx = document.getElementById('myChart')
    // eslint-disable-next-line no-unused-vars
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [
                'Sunday',
                'Monday',
                'Tuesday',
                'Wednesday',
                'Thursday',
                'Friday',
                'Saturday'
            ],
            datasets: [{
                data: [
                    15339,
                    21345,
                    18483,
                    24003,
                    23489,
                    24092,
                    12034
                ],
                lineTension: 0,
                backgroundColor: 'transparent',
                borderColor: '#007bff',
                borderWidth: 4,
                pointBackgroundColor: '#007bff'
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: false
                    }
                }]
            },
            legend: {
                display: false
            }
        }
    })
}())


function MsgBox() //声明标识符
{    var ID ="201830660413"
    var name,birth,address;
    name=prompt("请输入姓名");
    var sex =prompt("请输入性别");
    birth=prompt("请输入生日");
    phone=prompt("请输入联系电话")
    var table = document.getElementById("mm");
    oneRow = table.insertRow();//插入一行
    cell0 = oneRow.insertCell();
    cell1= oneRow.insertCell(); //单单插入一行是不管用的，需要插入单元格
    cell2=oneRow.insertCell();
    cell3 = oneRow.insertCell();
    cell4 =oneRow.insertCell();
    cell5 = oneRow.insertCell();
    cell6 = oneRow.insertCell();
    cell0.innerHTML = ++ID;
    cell1.innerHTML = name;
    cell2.innerHTML=sex;
    cell3.innerHTML= birth;
    cell4.innerHTML = phone;
    cell5.innerHTML = address;
    cell6.innerHTML = "正常";

}

function  del(obj) {
    if(confirm("确定删除这一行嘛？")){
        obj.parentNode.parentNode.remove();
    }

}

function attendent(obj){

    obj.innerHTML="已签到"
}

