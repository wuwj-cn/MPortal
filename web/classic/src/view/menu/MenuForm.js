Ext.define('MPortal.view.menu.MenuForm', {
	extend: 'Ext.form.Panel',
	xtype: 'menu-form',
	
	title: '基本信息',
    frame: true,
    resizable: true,
    minHeight: 200,

    layout: 'form',
    
    defaults: {
        defaultType: 'textfield'
    },
    
    items: [{
        items: [
            { name: 'code', fieldLabel: '菜单代码' },
            { name: 'name', fieldLabel: '菜单名称' },
            { name: 'parentCode', fieldLabel: '上级菜单' }
        ]
    }],
    
    buttons: [
        { text: '保存', formBind : true, disabled : true, handler: 'onOkClick' },
        { text: '取消' }
    ]
});