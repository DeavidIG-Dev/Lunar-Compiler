package lunar.tokenization.tokens

object TokenType {
	/**
	 * # [StartOfFileToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.0
	 * @return [Int] = 0
	 */
	const val StartOfFileToken: Int = 0

	/**
	 * # [EndOfFileToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.0
	 * @return [Int] = 1
	 */
	const val EndOfFileToken: Int = 1

	/**
	 * # [WhitespaceToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.4
	 * @return [Int] = 2
	 */
	const val WhitespaceToken: Int = 2

	/**
	 * # [IdentifierToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.1
	 * @return [Int] = 3
	 */
	const val IdentifierToken: Int = 3

	/**
	 * # [NumberLiteralTypeToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.1
	 * @return [Int] = 10
	 */
	const val NumberLiteralTypeToken = 10

	/**
	 * # [StringLiteralToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 11
	 */
	const val StringLiteralToken = 11

	/**
	 * # [CharacterLiteralToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 12
	 */
	const val CharacterLiteralToken = 12

	/**
	 * # [SymbolsOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.4
	 * @return [Int] = 20
	 */
	const val SymbolsOperatorToken = 20

	/**
	 * # [EqualSymbolOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.4
	 * @return [Int] = 30
	 */
	const val EqualSymbolOperatorToken = 30

	/**
	 * # [AndSymbolOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 31
	 */
	const val AndSymbolOperatorToken = 31

	/**
	 * # [VerticalLineSymbolOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 32
	 */
	const val VerticalLineSymbolOperatorToken = 32

	/**
	 * # [NotSymbolOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 33
	 */
	const val NotSymbolOperatorToken = 33

	/**
	 * # [QuestionSymbolOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 34
	 */
	const val QuestionSymbolOperatorToken = 34

	/**
	 * # [LessThanSymbolOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 35
	 */
	const val LessThanSymbolOperatorToken = 35

	/**
	 * # [GreaterThanSymbolOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 37
	 */
	const val GreaterThanSymbolOperatorToken = 37

	/**
	 * # [PlusSymbolArithmeticalOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.3
	 * @return [Int] = 40
	 */
	const val PlusSymbolArithmeticalOperatorToken = 40

	/**
	 * # [MinusSymbolArithmeticalOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.3
	 * @return [Int] = 41
	 */
	const val MinusSymbolArithmeticalOperatorToken = 41

	/**
	 * # [StarSymbolArithmeticalOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.3
	 * @return [Int] = 42
	 */
	const val StarSymbolArithmeticalOperatorToken = 42

	/**
	 * # [SlashSymbolArithmeticalOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.3
	 * @return [Int] = 43
	 */
	const val SlashSymbolArithmeticalOperatorToken = 43

	/**
	 * # [ModuleSymbolArithmeticalOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.3
	 * @return [Int] = 44
	 */
	const val ModuleSymbolArithmeticalOperatorToken = 44

	/**
	 * # [SemicolonSymbolDelimiterOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.3
	 * @return [Int] = 50
	 */
	const val SemicolonSymbolDelimiterOperatorToken = 50

	/**
	 * # [ColonSymbolDelimiterOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.3
	 * @return [Int] = 51
	 */
	const val ColonSymbolDelimiterOperatorToken = 51

	/**
	 * # [CommaSymbolDelimiterOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.3
	 * @return [Int] = 52
	 */
	const val CommaSymbolDelimiterOperatorToken = 52

	/**
	 * # [DotSymbolDelimiterOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.3
	 * @return [Int] = 53
	 */
	const val DotSymbolDelimiterOperatorToken = 53

	/**
	 * # [ParenthesisLeftSymbolDelimiterSeparatorOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 60
	 */
	const val ParenthesisLeftSymbolDelimiterSeparatorOperatorToken = 60

	/**
	 * # [ParenthesisRightSymbolDelimiterSeparatorOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 61
	 */
	const val ParenthesisRightSymbolDelimiterSeparatorOperatorToken = 61

	/**
	 * # [SquareLeftSymbolDelimiterSeparatorOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 62
	 */
	const val SquareLeftSymbolDelimiterSeparatorOperatorToken = 62

	/**
	 * # [SquareRightSymbolDelimiterSeparatorOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 63
	 */
	const val SquareRightSymbolDelimiterSeparatorOperatorToken = 63

	/**
	 * # [CurlyLeftSymbolDelimiterSeparatorOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 64
	 */
	const val CurlyLeftSymbolDelimiterSeparatorOperatorToken = 64

	/**
	 * # [CurlyRightSymbolDelimiterSeparatorOperatorToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @since 1.5
	 * @return [Int] = 65
	 */
	const val CurlyRightSymbolDelimiterSeparatorOperatorToken = 65

	/**
	 * # [ModuleCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 100
	 */
	const val ModuleKeywordToken: Int = 100

	/**
	 * # [PackageCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 101
	 */
	const val PackageKeywordToken: Int = 101

	/**
	 * # [ImportCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 102
	 */
	const val ImportKeywordToken: Int = 102

	/**
	 * # [FromCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 103
	 */
	const val FromKeywordToken: Int = 103

	/**
	 * # [OfCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 104
	 */
	const val OfKeywordToken: Int = 104

	/**
	 * # [PublicCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 105
	 */
	const val PublicKeywordToken: Int = 105

	/**
	 * # [PrivateCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 106
	 */
	const val PrivateKeywordToken: Int = 106

	/**
	 * # [ProtectedCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 107
	 */
	const val ProtectedKeywordToken: Int = 107

	/**
	 * # [ExternalCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 108
	 */
	const val ExternalKeywordToken: Int = 108

	/**
	 * # [InternalCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 109
	 */
	const val InternalKeywordToken: Int = 109

	/**
	 * # [InnerCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 110
	 */
	const val InnerKeywordToken: Int = 110

	/**
	 * # [ExnerCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 111
	 */
	const val ExnerKeywordToken: Int = 111

	/**
	 * # [FinalCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 112
	 */
	const val FinalKeywordToken: Int = 112

	/**
	 * # [AbstractCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 113
	 */
	const val AbstractKeywordToken: Int = 113

	/**
	 * # [OpenCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 114
	 */
	const val OpenKeywordToken: Int = 114

	/**
	 * # [CloseCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 115
	 */
	const val CloseKeywordToken: Int = 115

	/**
	 * # [SealedCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 116
	 */
	const val SealedKeywordToken: Int = 116

	/**
	 * # [CompanionCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 117
	 */
	const val CompanionKeywordToken: Int = 117

	/**
	 * # [FriendCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 118
	 */
	const val FriendKeywordToken: Int = 118

	/**
	 * # [AnnotationCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 119
	 */
	const val AnnotationKeywordToken: Int = 119

	/**
	 * # [ClassCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 120
	 */
	const val ClassKeywordToken: Int = 120

	/**
	 * # [DataCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 121
	 */
	const val DataKeywordToken: Int = 121

	/**
	 * # [RecordCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 122
	 */
	const val RecordKeywordToken: Int = 122

	/**
	 * # [StructureCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 123
	 */
	const val StructureKeywordToken: Int = 123

	/**
	 * # [EnumerateCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 124
	 */
	const val EnumerateKeywordToken: Int = 124

	/**
	 * # [AttributeCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 125
	 */
	const val AttributeKeywordToken: Int = 125

	/**
	 * # [DelegateCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 126
	 */
	const val DelegateKeywordToken: Int = 126

	/**
	 * # [InterfaceCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 127
	 */
	const val InterfaceKeywordToken: Int = 127

	/**
	 * # [TraitCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 128
	 */
	const val TraitKeywordToken: Int = 128

	/**
	 * # [ObjectCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 129
	 */
	const val ObjectKeywordToken: Int = 129

	/**
	 * # [ValueCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 130
	 */
	const val ValueKeywordToken: Int = 130

	/**
	 * # [ExtendCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 131
	 */
	const val ExtendKeywordToken: Int = 131

	/**
	 * # [ExtendsCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 132
	 */
	const val ExtendsKeywordToken: Int = 132

	/**
	 * # [ImplementCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 133
	 */
	const val ImplementKeywordToken: Int = 133

	/**
	 * # [ImplementsCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 134
	 */
	const val ImplementsKeywordToken: Int = 134

	/**
	 * # [PermitCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 135
	 */
	const val PermitKeywordToken: Int = 135

	/**
	 * # [PermitsCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 136
	 */
	const val PermitsKeywordToken: Int = 136

	/**
	 * # [CompanionsCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 137
	 */
	const val CompanionsKeywordToken: Int = 137

	/**
	 * # [FriendsCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 138
	 */
	const val FriendsKeywordToken: Int = 138

	/**
	 * # [WhereCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 139
	 */
	const val WhereKeywordToken: Int = 139

	/**
	 * # [WithCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 140
	 */
	const val WithKeywordToken: Int = 140

	/**
	 * # [WithsCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 141
	 */
	const val WithsKeywordToken: Int = 141

	/**
	 * # [LocalCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 142
	 */
	const val LocalKeywordToken: Int = 142

	/**
	 * # [GlobalCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 143
	 */
	const val GlobalKeywordToken: Int = 143

	/**
	 * # [OverrideCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 144
	 */
	const val OverrideKeywordToken: Int = 144

	/**
	 * # [SuffixCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 145
	 */
	const val SuffixKeywordToken: Int = 145

	/**
	 * # [PrefixCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 146
	 */
	const val PrefixKeywordToken: Int = 146

	/**
	 * # [OperatorCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 147
	 */
	const val OperatorKeywordToken: Int = 147

	/**
	 * # [ControlCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 148
	 */
	const val ControlKeywordToken: Int = 148

	/**
	 * # [InfixCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 149
	 */
	const val InfixKeywordToken: Int = 149

	/**
	 * # [FunctionCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 150
	 */
	const val FunctionKeywordToken: Int = 150

	/**
	 * # [NativeCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 151
	 */
	const val NativeKeywordToken: Int = 151

	/**
	 * # [ConstructorCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 152
	 */
	const val ConstructorKeywordToken: Int = 152

	/**
	 * # [InlineCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 153
	 */
	const val InlineKeywordToken: Int = 153

	/**
	 * # [ReadonlyCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 154
	 */
	const val ReadonlyKeywordToken: Int = 154

	/**
	 * # [WriteonlyCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 155
	 */
	const val WriteonlyKeywordToken: Int = 155

	/**
	 * # [TypeCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 156
	 */
	const val TypeKeywordToken: Int = 156

	/**
	 * # [LetCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 157
	 */
	const val LetKeywordToken: Int = 157

	/**
	 * # [SetCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 158
	 */
	const val SetKeywordToken: Int = 158

	/**
	 * # [GetCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 159
	 */
	const val GetKeywordToken: Int = 159

	/**
	 * # [ConstantCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 160
	 */
	const val ConstantKeywordToken: Int = 160

	/**
	 * # [AsCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 161
	 */
	const val AsKeywordToken: Int = 161

	/**
	 * # [ThisCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 162
	 */
	const val ThisKeywordToken: Int = 162

	/**
	 * # [SelfCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 163
	 */
	const val SelfKeywordToken: Int = 163

	/**
	 * # [SuperCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 164
	 */
	const val SuperKeywordToken: Int = 164

	/**
	 * # [BaseCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 165
	 */
	const val BaseKeywordToken: Int = 165

	/**
	 * # [ReturnCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 166
	 */
	const val ReturnKeywordToken: Int = 166

	/**
	 * # [NewCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 167
	 */
	const val NewKeywordToken: Int = 167

	/**
	 * # [GotoCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 168
	 */
	const val GotoKeywordToken: Int = 168

	/**
	 * # [EndCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 169
	 */
	const val EndKeywordToken: Int = 169

	/**
	 * # [ThenCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 170
	 */
	const val ThenKeywordToken: Int = 170

	/**
	 * # [IfCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 200
	 */
	const val IfKeywordToken: Int = 200

	/**
	 * # [ElseCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 201
	 */
	const val ElseKeywordToken: Int = 201

	/**
	 * # [InCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 202
	 */
	const val InKeywordToken: Int = 202

	/**
	 * # [IsCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 203
	 */
	const val IsKeywordToken: Int = 203

	/**
	 * # [DoCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 204
	 */
	const val DoKeywordToken: Int = 204

	/**
	 * # [WhileCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 205
	 */
	const val WhileKeywordToken: Int = 205

	/**
	 * # [BreakCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 206
	 */
	const val BreakKeywordToken: Int = 206

	/**
	 * # [ContinueCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 207
	 */
	const val ContinueKeywordToken: Int = 207

	/**
	 * # [ByCharArray]
	 *
	 * <Missing Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 * @return [Int] = 208
	 */
	const val ByKeywordToken: Int = 208
}