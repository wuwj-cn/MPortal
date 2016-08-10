/**
 * This class manages the User view.
 */
Ext.define('MPortal.view.user.UserController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.user', // enable "controller: 'user'" in the User view
    
    onGroupsClick: function() {
        var groups = new Ticket.view.user.Group();
        groups.show();
    },
    
    onOkClick: function() {
    	var user = Ext.create('MPortal.model.User', {username: '002', password: '123456'});
    	user.save({
    		failure: function(record, operation) {
    	        console.log('failure');
    	    },
    	    success: function(record, operation) {
    	        record.set('username', '002-1');
    	        record.set('password', '123');
    	        record.save();
    	    },
    	    callback: function(record, operation, success) {
    	        console.log('callback');
    	    }
    	});
    }
});
