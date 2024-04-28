import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

public class GraphQLExample {
    private static GraphQLSchema schema = GraphQLSchema.newSchema()
        .query(newObject()
            .name("query")
            .field(newFieldDefinition()
                .name("test")
                .type(GraphQLString)
                .staticValue("Hello World"))
            .build())
        .build();

    public static void main(String[] args) {
        GraphQL graphql = GraphQL.newGraphQL(schema).build();
        String query = "{ test }";
        System.out.println(graphql.execute(query).getData().toString());
    }
}
