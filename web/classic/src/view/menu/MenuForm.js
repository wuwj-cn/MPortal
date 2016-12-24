Ext.define('MPortal.view.menu.MenuForm', {
	extend: 'Ext.form.Panel',
	xtype: 'menu-form',
	
	title: '基本信息',
	bodyPadding: 5,
    frame: true,
    scrollable: true,

    layout: 'anchor',
    
    defaults: {
    	anchor: '95%',
    	labelAlign: 'right',
    	labelWidth: 80
    },
    defaultType: 'textfield',
    
    items: [
    	{ name: 'code', fieldLabel: '菜单代码', allowBlank: false, emptyText: '请输入菜单代码' },
        { name: 'name', fieldLabel: '菜单名称', allowBlank: false },
        { name: 'url', fieldLabel: 'URL', allowBlank: false, inputType: 'url' },
        { name: 'parent.name', fieldLabel: '上级菜单', readOnly: true },
        { name: 'remark', fieldLabel: '备注', xtype: 'textarea', grow: true, height: 100 },
        { name: 'id', hidden: true},
        { name: 'parent.id', hidden: true}
    ],
    
//    tbar: [
//        {name: 'addMenu', text: '增加本级菜单', iconCls: 'x-fa fa-plus-circle', handler : 'onAdd'},
//        {name: 'addSubMenu', text: '增加下级菜单', iconCls: 'x-fa fa-plus-circle', handler : 'onAdd'}
//    ],
    tools: [{
    	type:'plus',
        tooltip: '增加本级菜单',
        handler: 'onAdd'
    }, {
    	type:'collapse',
        tooltip: '增加下级菜单',
        handler: 'onAddSub'
    }, {
    	type:'minus',
        tooltip: '删除',
        handler: 'onAdd'
    }, {
    	type:'refresh',
        tooltip: '刷新',
        handler: 'onAdd'
    }],
    
    buttons: [
        { text: '保存', formBind : true, disabled : true, handler: 'onSave' },
        { text: '取消' }
    ]
});