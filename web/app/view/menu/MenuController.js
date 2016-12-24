Ext.define('MPortal.view.menu.MenuController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.m-menu',
    
    constructor: function(config) {
        var me = this;
        me.menu = Ext.create('MPortal.model.Menu');
    },
    
    onSave: function(button, event) {
    	var me = this,
    		form = button.up('form').getForm(),
    		store = Ext.StoreMgr.get('menus'),
    		tree = me.lookupReference('menu-tree'),
    		target = tree.getSelection()[0] || tree.getRootNode();
    	me.menu.set(form.getValues());
    	me.menu.data.parent = {id: form.findField('parent.id').getValue()};
    	console.log(me.menu);
    	me.menu.save({
    		success: function(record, options) {
//	    	    if (!target.isExpanded()) {
//	    	        target.expand(true);
//	    	    }
//	    	    record = target.appendChild(record);
//	    	    tree.selModel.select(record);
	    	    tree.getStore().load({node: target});
    		}
    	});
    },
    
    onItemClick : function(view, record, item, index, e, eOpts) {
		var me = this, 
			formPanel = me.lookupReference('menu-form'),
			tree = me.lookupReference('menu-tree'),
			form = formPanel.getForm();
		MPortal.model.Menu.load(record.getId(), {
			success: function(rec, options) {
	    	    form.setValues(rec.data);
	    	    form.findField('parent.name').setValue(rec.data.parent.name);
	    	    form.findField('parent.id').setValue(rec.data.parent.id);
	    	    me.menu = rec;
    		} 
		});
//		form.findField('id').setValue(target.data.id);
//		form.findField('code').setValue(target.data.code);
//		form.findField('name').setValue(target.data.text);
//		form.findField('parent.name').setValue(target.parentNode.data.text);
//		form.findField('parent.id').setValue(target.parentNode.data.id);
	},
	
	onAdd: function(button, event) {
		var me = this,
			formPanel = me.lookupReference('menu-form'),
			tree = me.lookupReference('menu-tree'),
			target = tree.getSelection()[0] || tree.getRootNode(),
			form = formPanel.getForm();
		form.reset();
		form.findField('parent.name').setValue(target.parentNode.data.text);
		form.findField('parent.id').setValue(target.parentNode.data.id);
	},
	onAddSub: function(button, event) {
		var me = this,
			formPanel = me.lookupReference('menu-form'),
			tree = me.lookupReference('menu-tree'),
			target = tree.getSelection()[0] || tree.getRootNode(),
			form = formPanel.getForm();
		form.reset();
		form.findField('parent.name').setValue(target.data.text);
		form.findField('parent.id').setValue(target.data.id);
	},
});
