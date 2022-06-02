package fr.cnumr.python.checks;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.python.api.PythonSubscriptionCheck;
import org.sonar.plugins.python.api.SubscriptionContext;
import org.sonar.plugins.python.api.tree.TryStatement;

@Rule(
        key = AvoidStringInSetTimeoutAndSetIntervalCheck.RULE_KEY,
        name = "Developpement",
        description = AvoidStringInSetTimeoutAndSetIntervalCheck.DESCRIPTION,
        priority = Priority.MINOR,
        tags = {"bug"})
public class AvoidStringInSetTimeoutAndSetIntervalCheck extends PythonSubscriptionCheck {

    public static final String RULE_KEY = "S52";
    public static final String DESCRIPTION = "Avoid strings as arguments to SetTimeout() and setInterval()";

    @Override
    public void initialize(Context context) {
        // TODO
    }

    public void visitNode(SubscriptionContext ctx) {
        TryStatement tryStatement = (TryStatement) ctx.syntaxNode();
        ctx.addIssue(tryStatement.tryKeyword(), DESCRIPTION);

    }

}
