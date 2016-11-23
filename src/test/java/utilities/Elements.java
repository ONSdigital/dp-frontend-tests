package utilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 21/10/2016.
 */
public class Elements {

    public static Map<String, String> elementMapping;

    static{
        elementMapping = new HashMap<String, String>();

        // Florence - LoginPage
        elementMapping.put("Email", "email");
        elementMapping.put("Password", "password");


        // Florence - Collections
        elementMapping.put("Collection name", "collectionname");
        elementMapping.put("Manual publish", "manualpublish");
        elementMapping.put("Scheduled publish", "scheduledpublish");
        elementMapping.put("Custom schedule", "customschedule");
        elementMapping.put("Date", "date");
        elementMapping.put("Hour", "hour");
        elementMapping.put("Minute", "min");

        elementMapping.put("Create collection", ".btn.btn--positive.margin-right--0.float-right.btn-collection-create");
        elementMapping.put("Log in", "#login");

        elementMapping.put("Content", "#content");
        elementMapping.put("Metadata", "#ui-id-3");

        elementMapping.put("Markdown editor", "wmd-input");

        elementMapping.put("Save changes and exit", ".btn.btn--positive.btn-markdown-editor-exit");

        elementMapping.put("Save and submit for review", ".btn.btn--positive.btn-edit-save-and-submit-for-review");

        elementMapping.put("Edit Collection details", "complete-uris");

        elementMapping.put("Review file", ".btn.btn-page-edit");

        elementMapping.put("Save and submit for approval", ".btn.btn--positive.btn-edit-save-and-submit-for-approval");

        elementMapping.put("Approve collection", ".btn.btn--positive.btn-collection-approve");

        elementMapping.put("Test Collections", ".collection-name");

        elementMapping.put("Publish collection", ".btn.btn--positive.margin-top--1.margin-bottom--0.btn-collection-publish");

        elementMapping.put("OK", ".confirm");

        elementMapping.put("Select the team the collection can be previewed by", "team");

        elementMapping.put("New page type", "pagetype");

        elementMapping.put("Page name", "pagename");

        elementMapping.put("Create page", ".btn.btn--positive.margin-left--0.btn-page-create");

        elementMapping.put("Title", "title");

        elementMapping.put("Summary", "summary");

        elementMapping.put("Keywords", "keywordsTag");

        elementMapping.put("Meta description", "metaDescription");

        elementMapping.put("Collections", ".collections-select-table");

        elementMapping.put("Select a document to view", "docs-list");

        elementMapping.put("Page title", ".//*[@id='main']/div[1]/div/div/div/div/h1");

        elementMapping.put("Title summary", ".//*[@id='main']/div[1]/div/div/div/div/p");

        elementMapping.put("Delete file", ".btn.btn--warning.btn-page-delete.page-delete");

        elementMapping.put("Continue", ".confirm");

        elementMapping.put("Create", ".btn.btn--positive.btn-browse-create");

        elementMapping.put("Select your option", "pagetype");

        elementMapping.put("Upload visualisation", ".btn.btn--positive.btn-browse-create-datavis");

        elementMapping.put("Unique ID", "visualisation-uid");


        //Users and access
        elementMapping.put("Username", "create-user-username");

        elementMapping.put("Create a user Email", "create-user-email");

        elementMapping.put("Create a user Password", "create-user-password");

        elementMapping.put("Viewer", "viewer-type");

        elementMapping.put("Administrator", "admin-type");

        elementMapping.put("Publisher", "publisher-type");

        elementMapping.put("Visualisation publisher", "data-vis-type");

        elementMapping.put("Viewer", "viewer-type");

        elementMapping.put("Create user", ".btn.btn--positive.margin-right--0.float-right.btn-collection-create");

        elementMapping.put("Select a user", ".collection-name");

        elementMapping.put("Delete user", ".btn.btn--warning.btn-user-delete");

        elementMapping.put("Confirm deletion", "html/body/div[5]/fieldset/input");

        elementMapping.put("Delete", ".confirm");

        elementMapping.put("Select a team", ".table.table--primary.table--fixed-height-27.js-selectable-table");

        elementMapping.put("Delete team", ".btn.btn--warning.btn-team-delete");

        elementMapping.put("Delete collection", "#collection-delete");


        //Teams
        elementMapping.put("Team Name", "create-team-name");

        elementMapping.put("Create team", ".btn.btn--positive.float-right.margin-right--0.btn-collection-create");

        elementMapping.put("Add/remove members", ".btn.btn--primary.btn-team-edit-members");

        elementMapping.put("Search for a user", "team-search-input");

        elementMapping.put("Add", ".btn-team-list.btn-team-add");

        elementMapping.put("Done", ".btn.btn-team-selector-cancel");

        // Ermintrude - After Successful login - change password

        elementMapping.put("Current password", "password-old");

        elementMapping.put("New password", "password-new");

        elementMapping.put("Confirm new password", "password-confirm");

        elementMapping.put("Update password", "#update-password");


    }
}
