package cn.agilean.kanban.jenkins

lib.FormTagLib f = namespace(lib.FormTagLib)
lib.CredentialsTagLib c  = namespace(lib.CredentialsTagLib)

f.entry(title: "用户",field:'credentialsId'){
    c.select()
}
//f.entry(title:"username"){
//    f.textbox(name:"username",value:instance?.username)
//}
//f.entry(title:"password"){
//    f.password(name:"password",value:instance?.password)
//}
f.entry(title: "看板",field:"board"){
    f.textbox( name:"board",title: "选择看板",value:instance?.board)
}
f.entry(title: "卡片",field:"card"){
    f.textbox( name:"card",title: "输入卡片名称",value:instance?.card)
}
f.entry(title: "移动到",field:"step"){
    f.textbox( name:"step",title: "选择移动到哪一步",value:instance?.step)
}

//f.entry(title:_("看板"),description:_("description",rootURL)) {
//    f.textarea(name: "command",
//        value: instance?.command,
//        class: "fixed-width",
//        'codemirror-mode': 'shell',
//        'codemirror-config': "mode: 'text/x-sh'")
//}

//f.advanced() {
//    f.entry(title:_("Exit code to set build unstable"), field: "unstableReturn") {
//        f.number(clazz:"positive-number", value: instance?.unstableReturn, min:1, max:255, step:1)
//    }
//}