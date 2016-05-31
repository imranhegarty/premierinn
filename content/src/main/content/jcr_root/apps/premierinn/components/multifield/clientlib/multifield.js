
try {
    if (typeof MULTIFILEDPANELLIST == 'undefined') {
        MULTIFILEDPANELLIST = {}; // creating namespace
    }
    MULTIFILEDPANELLIST.CustomImageListWidget = CQ.Ext.extend(CQ.form.CompositeField, {

        /**
         * @private
         * @type CQ.Ext.form.TextField
         */
        hiddenField: null,

       /**
        * @private
        * @type CQ.Ext.form.TextField
        */
        title: null,

        /**
         * @private
         * @type CQ.Ext.form.TextArea
         */
        richTextArea: null,

        /**
         * @private
         * @type CQ.form.PathField
         */
        image: null,
    
        constructor: function(config) {
            config = config || { };
            var defaults = {
                "border": true,
                "layout": "form",
                "padding": 10,
                style:"width:700px"
            };
            config = CQ.Util.applyDefaults(config, defaults);
            MULTIFILEDPANELLIST.CustomImageListWidget.superclass.constructor.call(this, config);
        },
    
        // overriding CQ.Ext.Component#initComponent
        initComponent: function() {
            MULTIFILEDPANELLIST.CustomImageListWidget.superclass.initComponent.call(this);
            this.hiddenField = new CQ.Ext.form.Hidden({
                name: this.name
            });
    
            this.add(this.hiddenField);

            //Name - START

            this.title = new CQ.Ext.form.TextField({
                fieldLabel: "Title ",
                fieldDescription: "Provide a title",
                width:400,
                listeners: {
                    change: {
                        scope:this,
                        fn:this.updateHidden
                    }
                }
            });
            this.add(this.title);
    
            //Name - END

            //Description - START

            this.richTextArea= new CQ.form.RichText({
                fieldLabel: "Text",
                allowBlank: true,
                fieldDescription: "Enter some text",
                width: 400,
                listeners: {
                    change: {
                        scope: this,
                        fn: this.updateHidden },
                    destroy: {
                        scope: this,
                        fn: this.descDestroy }
                }
            });
            this.add(this.richTextArea);

            //Description - END

            //Image - START 
    
            this.image = new CQ.form.PathField ({
                fieldLabel: "Image",
                rootPath:"/content/dam",
                regex :/\.(png|jpg|jpeg|gif|tiff|bmp|pnm|pgm|pbm|ppm|psd|eps|dng)$/,
                regexText : "Please choose an image file",
                editable : true,
                allowBlank: true,
                fieldDescription: "Select an image from the pathfinder",
                width: 225,
                listeners: {
                    change: {
                        scope: this,
                        fn: this.updateHidden
                    },
                    dialogclose: {
                        scope: this,
                        fn: this.updateHidden
                    }
                }
            });
            this.add(this.image);
    
            //Image - END
    
        },
     
        // overriding CQ.form.CompositeField#processPath
        processPath: function(path) {
            console.log("CustomWidget#processPath", path);
            this.image.processPath(path);
            //this.linkType.processPath(path);
        },
     
        // overriding CQ.form.CompositeField#processRecord
        processRecord: function(record, path) {
            console.log("CustomWidget#processRecord", path, record);
            this.image.processRecord(record, path);
            //this.linkType.processRecord(record, path);
        },
     
        // overriding CQ.form.CompositeField#setValue
        setValue: function(value) {
            if (value){
            	var parts = value.split("|");
                if (parts.length > 0){
            		this.title.setValue(parts[0]);
            		this.richTextArea.setValue(parts[1]);
                    this.image.setValue(parts[2]);
            		//this.hiddenField.setValue(value);
                }
            }
        },

        // overriding CQ.form.CompositeField#getValue
        getValue: function() {
            return this.getRawValue();
        },

        // overriding CQ.form.CompositeField#getRawValue
        getRawValue: function() {
			var title = this.title.getValue();
            var richTextArea = this.richTextArea.getValue();
            var image = this.image.getValue();

            if (title == '')
                title = " ";
            if (richTextArea == '')
                richTextArea = " ";
           	var value = title + "|" + richTextArea + "|" + image;
            this.hiddenField.setValue(value);
            return value;
        },

        // private
        updateHidden: function() {
            //alert('customwidget updatehidden');
            this.hiddenField.setValue(this.getValue());
        },
        descDestroy: function() {
            this.news.el.dom = {};
        }
    });
    // register xtype
    CQ.Ext.reg("multifieldpanellist", MULTIFILEDPANELLIST.CustomImageListWidget);
    
} catch (e) {
}
