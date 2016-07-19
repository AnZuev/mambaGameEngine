package innopolis.mammba.engine.errors;

/**
 * Created by anton on 17/07/16.
 *
 */

public enum GameFlowErrorType{
    incorrectAction,
    actionIsNotAllowed,
    noEnoughMoney,
    notYourTurn,
    accessForbidden,
    incorrectStakeAmountForCallAction,
    noPlayersFoundToPlayInRound,
    gameFinished
}