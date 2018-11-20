package cn.agilean.kanban.jenkins

import lib.FormTagLib

lib.FormTagLib f = namespace(lib.FormTagLib)

f.section(title:'看板'){
    f.entry(title:"服务器地址",field:'server'){
        f.textbox()
        // repeat 要求element必须是对象，string的话会报错误没有descripor对象
        //        f.repeatableHeteroProperty()
        //        f.repeatableHeteroProperty(field:"servers",default: "https://tkb.agilean.cn/")
    }
}
