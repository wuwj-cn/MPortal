Ext.define('MPortal.view.menu.MenuController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.m-menu',
    
    onOkClick: function(button, event) {
    	var me = this,
    		form = button.up('form').getForm(),
    		store = Ext.StoreMgr.get('menus'),
    		menu = Ext.create('MPortal.model.Menu', form.getValues()),
    		tree = me.lookupReference('menu-tree');
//    	store.add(menu);
    	console.log(menu);
    	menu.save({
    		success: function(record, options) {
    			var target = tree.selModel.getSelection()[0] || tree.getRootNode();
	    	    if (!target.isExpanded()) {
	    	        target.expand(true);
	    	    }
	    	    record = target.appendChild(record);
	    	    tree.selModel.select(record);
    		}
    	});
    }
});
